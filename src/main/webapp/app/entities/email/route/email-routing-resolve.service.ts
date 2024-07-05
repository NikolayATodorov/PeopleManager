import { inject } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRouteSnapshot, Router } from '@angular/router';
import { of, EMPTY, Observable } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

import { IEmail } from '../email.model';
import { EmailService } from '../service/email.service';

const emailResolve = (route: ActivatedRouteSnapshot): Observable<null | IEmail> => {
  const id = route.params['id'];
  if (id) {
    return inject(EmailService)
      .find(id)
      .pipe(
        mergeMap((email: HttpResponse<IEmail>) => {
          if (email.body) {
            return of(email.body);
          } else {
            inject(Router).navigate(['404']);
            return EMPTY;
          }
        }),
      );
  }
  return of(null);
};

export default emailResolve;
