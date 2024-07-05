import { IEmail, NewEmail } from './email.model';

export const sampleWithRequiredData: IEmail = {
  id: 1671,
  emailType: 'headq',
  email: '/s.c-.9=|lx.{_k._#wqz@[253.252.046.194]',
};

export const sampleWithPartialData: IEmail = {
  id: 8974,
  emailType: 'wisel',
  email: '"\\c\\cJ"@[239.045.201.4]',
};

export const sampleWithFullData: IEmail = {
  id: 9700,
  emailType: 'if',
  email: '"\\j"@6je.j.0k.oxzfjc.svw',
};

export const sampleWithNewData: NewEmail = {
  emailType: 'sans',
  email: undefined,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
