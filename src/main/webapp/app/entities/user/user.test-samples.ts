import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 27158,
  login: 'x&9a@1QI\\Gp6L\\]8tLErc\\A1N\\wPP',
};

export const sampleWithPartialData: IUser = {
  id: 14988,
  login: 'S=0Ea@W\\<56FdJ\\S7SLF4F',
};

export const sampleWithFullData: IUser = {
  id: 5521,
  login: 'AKb@36vAE',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
