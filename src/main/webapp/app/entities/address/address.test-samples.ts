import { IAddress, NewAddress } from './address.model';

export const sampleWithRequiredData: IAddress = {
  id: 5629,
  addressType: 'grim ',
};

export const sampleWithPartialData: IAddress = {
  id: 30382,
  addressType: 'inclu',
};

export const sampleWithFullData: IAddress = {
  id: 20050,
  addressType: 'near ',
  addressInfo: 'fence simplistic sans',
};

export const sampleWithNewData: NewAddress = {
  addressType: 'phew',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
