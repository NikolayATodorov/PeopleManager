import { IPerson } from 'app/entities/person/person.model';

export interface IAddress {
  id: number;
  addressType?: string | null;
  addressInfo?: string | null;
  person?: Pick<IPerson, 'id' | 'fullName'> | null;
}

export type NewAddress = Omit<IAddress, 'id'> & { id: null };
