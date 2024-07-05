import { Routes } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { ASC } from 'app/config/navigation.constants';
import { EmailComponent } from './list/email.component';
import { EmailDetailComponent } from './detail/email-detail.component';
import { EmailUpdateComponent } from './update/email-update.component';
import EmailResolve from './route/email-routing-resolve.service';

const emailRoute: Routes = [
  {
    path: '',
    component: EmailComponent,
    data: {
      defaultSort: 'id,' + ASC,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: EmailDetailComponent,
    resolve: {
      email: EmailResolve,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: EmailUpdateComponent,
    resolve: {
      email: EmailResolve,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: EmailUpdateComponent,
    resolve: {
      email: EmailResolve,
    },
    canActivate: [UserRouteAccessService],
  },
];

export default emailRoute;
