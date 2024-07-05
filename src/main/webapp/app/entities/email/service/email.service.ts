import { inject, Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { isPresent } from 'app/core/util/operators';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { createRequestOption } from 'app/core/request/request-util';
import { IEmail, NewEmail } from '../email.model';

export type PartialUpdateEmail = Partial<IEmail> & Pick<IEmail, 'id'>;

export type EntityResponseType = HttpResponse<IEmail>;
export type EntityArrayResponseType = HttpResponse<IEmail[]>;

@Injectable({ providedIn: 'root' })
export class EmailService {
  protected http = inject(HttpClient);
  protected applicationConfigService = inject(ApplicationConfigService);

  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/emails');

  create(email: NewEmail): Observable<EntityResponseType> {
    return this.http.post<IEmail>(this.resourceUrl, email, { observe: 'response' });
  }

  update(email: IEmail): Observable<EntityResponseType> {
    return this.http.put<IEmail>(`${this.resourceUrl}/${this.getEmailIdentifier(email)}`, email, { observe: 'response' });
  }

  partialUpdate(email: PartialUpdateEmail): Observable<EntityResponseType> {
    return this.http.patch<IEmail>(`${this.resourceUrl}/${this.getEmailIdentifier(email)}`, email, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IEmail>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IEmail[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  getEmailIdentifier(email: Pick<IEmail, 'id'>): number {
    return email.id;
  }

  compareEmail(o1: Pick<IEmail, 'id'> | null, o2: Pick<IEmail, 'id'> | null): boolean {
    return o1 && o2 ? this.getEmailIdentifier(o1) === this.getEmailIdentifier(o2) : o1 === o2;
  }

  addEmailToCollectionIfMissing<Type extends Pick<IEmail, 'id'>>(
    emailCollection: Type[],
    ...emailsToCheck: (Type | null | undefined)[]
  ): Type[] {
    const emails: Type[] = emailsToCheck.filter(isPresent);
    if (emails.length > 0) {
      const emailCollectionIdentifiers = emailCollection.map(emailItem => this.getEmailIdentifier(emailItem));
      const emailsToAdd = emails.filter(emailItem => {
        const emailIdentifier = this.getEmailIdentifier(emailItem);
        if (emailCollectionIdentifiers.includes(emailIdentifier)) {
          return false;
        }
        emailCollectionIdentifiers.push(emailIdentifier);
        return true;
      });
      return [...emailsToAdd, ...emailCollection];
    }
    return emailCollection;
  }
}
