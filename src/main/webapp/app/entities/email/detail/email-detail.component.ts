import { Component, input } from '@angular/core';
import { RouterModule } from '@angular/router';

import SharedModule from 'app/shared/shared.module';
import { DurationPipe, FormatMediumDatetimePipe, FormatMediumDatePipe } from 'app/shared/date';
import { IEmail } from '../email.model';

@Component({
  standalone: true,
  selector: 'jhi-email-detail',
  templateUrl: './email-detail.component.html',
  imports: [SharedModule, RouterModule, DurationPipe, FormatMediumDatetimePipe, FormatMediumDatePipe],
})
export class EmailDetailComponent {
  email = input<IEmail | null>(null);

  previousState(): void {
    window.history.back();
  }
}
