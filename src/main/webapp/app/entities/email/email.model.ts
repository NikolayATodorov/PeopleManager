import { IPerson } from 'app/entities/person/person.model';

export interface IEmail {
  id: number;
  emailType?: string | null;
  email?: string | null;
  person?: Pick<IPerson, 'id' | 'fullName'> | null;
}

export type NewEmail = Omit<IEmail, 'id'> & { id: null };
