export class Movimento {
  id?: string;
  entrada?: Date;
  saida?: Date;
  veiculoId?: string;
  vagaId?: number;
  duracao?: string;
  veiculoPlaca?: string;
}

export class MovimentoPage {
  content?: Movimento[];
  last?: boolean;
  totalElements?: number;
  totalPages?: number;
  size?: number;
  number?: number;
  first?: boolean;
  numberOfElements?: number;
  empty?: boolean;
}
