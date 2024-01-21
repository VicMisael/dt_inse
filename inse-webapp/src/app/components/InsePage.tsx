// pages/InsePage.tsx
import React, { useState, useEffect } from 'react';
import InseDataTable from '../components/InseDataTable';
import SearchForm from '../components/SearchForm';

import { InseData, InseItem, InseQueryParams } from '../types/InseData';
import { fetchInseData } from '../service/InseService';
import AggregationComponent from './AggregationData';

const InsePage: React.FC = () => {
  const [data, setData] = useState<InseData>({
    pagination:{
      page:0,
      total:0,
      perPage:0,
      items:[]
    },
    averages:{
      QtdAlunos: 0,
      MediaInse: 0,
      PorcentagemNivel1: 0,
      PorcentagemNivel2: 0,
      PorcentagemNivel3: 0,
      PorcentagemNivel4: 0,
      PorcentagemNivel5: 0,
      PorcentagemNivel6: 0,
      PorcentagemNivel7: 0,
      PorcentagemNivel8: 0
    }

  }
  )
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<Error | null>(null);
  const [queryParams, setQueryParams] = useState<InseQueryParams>({});

  const fetchData = async () => {
    setLoading(true);
    try {
      const response = await fetchInseData(queryParams);
      setData(response);
    } catch (err) {
      setError(err as Error);
    }
    setLoading(false);
  };

  useEffect(() => {
    fetchData();
  }, [queryParams]);

  const handleSearch = (newParams: InseQueryParams) => {
    setQueryParams({ ...queryParams, ...newParams });
  };

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error.message}</div>;

  return (
    <div>
      <SearchForm onSearch={handleSearch} />
      <InseDataTable data={data?.pagination.items} />
      <AggregationComponent data={data?.averages}/>
    </div>
  );
};

export default InsePage;
