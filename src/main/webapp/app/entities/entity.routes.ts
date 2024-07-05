import { Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'authority',
    data: { pageTitle: 'Authorities' },
    loadChildren: () => import('./admin/authority/authority.routes'),
  },
  {
    path: 'person',
    data: { pageTitle: 'People' },
    loadChildren: () => import('./person/person.routes'),
  },
  {
    path: 'email',
    data: { pageTitle: 'Emails' },
    loadChildren: () => import('./email/email.routes'),
  },
  {
    path: 'address',
    data: { pageTitle: 'Addresses' },
    loadChildren: () => import('./address/address.routes'),
  },
  /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
];

export default routes;
