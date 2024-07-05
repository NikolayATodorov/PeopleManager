import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { IEmail, NewEmail } from '../email.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IEmail for edit and NewEmailFormGroupInput for create.
 */
type EmailFormGroupInput = IEmail | PartialWithRequiredKeyOf<NewEmail>;

type EmailFormDefaults = Pick<NewEmail, 'id'>;

type EmailFormGroupContent = {
  id: FormControl<IEmail['id'] | NewEmail['id']>;
  emailType: FormControl<IEmail['emailType']>;
  email: FormControl<IEmail['email']>;
  person: FormControl<IEmail['person']>;
};

export type EmailFormGroup = FormGroup<EmailFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class EmailFormService {
  createEmailFormGroup(email: EmailFormGroupInput = { id: null }): EmailFormGroup {
    const emailRawValue = {
      ...this.getFormDefaults(),
      ...email,
    };
    return new FormGroup<EmailFormGroupContent>({
      id: new FormControl(
        { value: emailRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        },
      ),
      emailType: new FormControl(emailRawValue.emailType, {
        validators: [Validators.required, Validators.maxLength(5)],
      }),
      email: new FormControl(emailRawValue.email, {
        validators: [
          Validators.required,
          Validators.maxLength(40),
          Validators.pattern(
            '(?:[a-z0-9!#$%&amp;&#39;*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&amp;&#39;*+/=?^_`{|}~-]+)*|&#34;(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*&#34;)@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])',
          ),
        ],
      }),
      person: new FormControl(emailRawValue.person, {
        validators: [Validators.required],
      }),
    });
  }

  getEmail(form: EmailFormGroup): IEmail | NewEmail {
    return form.getRawValue() as IEmail | NewEmail;
  }

  resetForm(form: EmailFormGroup, email: EmailFormGroupInput): void {
    const emailRawValue = { ...this.getFormDefaults(), ...email };
    form.reset(
      {
        ...emailRawValue,
        id: { value: emailRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */,
    );
  }

  private getFormDefaults(): EmailFormDefaults {
    return {
      id: null,
    };
  }
}
