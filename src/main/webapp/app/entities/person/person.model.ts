export interface IPerson {
  id: number;
  fullName?: string | null;
  pin?: string | null;
}

export type NewPerson = Omit<IPerson, 'id'> & { id: null };
