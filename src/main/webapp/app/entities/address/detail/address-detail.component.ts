import { Component, input } from '@angular/core';
import { RouterModule } from '@angular/router';

import SharedModule from 'app/shared/shared.module';
import { DurationPipe, FormatMediumDatetimePipe, FormatMediumDatePipe } from 'app/shared/date';
import { IAddress } from '../address.model';

@Component({
  standalone: true,
  selector: 'jhi-address-detail',
  templateUrl: './address-detail.component.html',
  imports: [SharedModule, RouterModule, DurationPipe, FormatMediumDatetimePipe, FormatMediumDatePipe],
})
export class AddressDetailComponent {
  address = input<IAddress | null>(null);

  previousState(): void {
    window.history.back();
  }
}
