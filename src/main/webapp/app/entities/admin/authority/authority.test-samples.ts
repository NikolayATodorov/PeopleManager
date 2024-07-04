import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: '781e93ee-a442-40f3-9aa0-f9772aef6579',
};

export const sampleWithPartialData: IAuthority = {
  name: 'f0112d85-9519-473d-9e97-8bfac4bb5932',
};

export const sampleWithFullData: IAuthority = {
  name: 'a2081418-efca-4dff-9631-5f219435bc1d',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
