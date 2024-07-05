import { IPerson, NewPerson } from './person.model';

export const sampleWithRequiredData: IPerson = {
  id: 2234,
  fullName: 'eKjGLwDFvG',
};

export const sampleWithPartialData: IPerson = {
  id: 19176,
  fullName: 'uQblSx-Frjk',
};

export const sampleWithFullData: IPerson = {
  id: 922,
  fullName: 'rWpXGcdLFv',
  pin: '1891988949',
};

export const sampleWithNewData: NewPerson = {
  fullName: 'ucbALlFMKhSV',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
