// types/InseData.ts
export interface InseQueryParams {
    page?: number;
    perPage?: number;
    orderMediaInse?: 'Asc' | 'Desc';
    uf?: string;
    orderUf?: 'Asc' | 'Desc';
    municipio?: string;
    orderMunicipio?: 'Asc' | 'Desc';
    querySchoolName?: string;
    orderBySchoolName?: 'Asc' | 'Desc';
  }

export interface InseData {
    pagination: InsePagination;
    averages: InseAverages;
  }
  
  interface InsePagination {
    page: number;
    total: number;
    perPage: number;
    items: InseItem[];
  }
  
  export interface InseItem {
    AnoSaeb: string;
    CodUF: number;
    NomeUF: string;
    CodMunicipio: number;
    NomeMunicipio: string;
    IdEscola: number;
    NomeEscola: string;
    tipoRede: 'Federal' | 'Estadual' |'Municipal'; 
    tipoLocalizacao: 'Urbana' | 'Rural'; 
    tipoCapital: 'Capital' | 'Interior'; 
    QtdAlunos: number;
    MediaInse: number;
    InseClassificacao: string;
    PorcentagemNivel1: number;
    PorcentagemNivel2: number;
    PorcentagemNivel3: number;
    PorcentagemNivel4: number;
    PorcentagemNivel5: number;
    PorcentagemNivel6: number;
    PorcentagemNivel7: number;
    PorcentagemNivel8: number;
  }
  
 export interface InseAverages {
    QtdAlunos: number;
    MediaInse: number;
    PorcentagemNivel1: number;
    PorcentagemNivel2: number;
    PorcentagemNivel3: number;
    PorcentagemNivel4: number;
    PorcentagemNivel5: number;
    PorcentagemNivel6: number;
    PorcentagemNivel7: number;
    PorcentagemNivel8: number;
  }
  
  