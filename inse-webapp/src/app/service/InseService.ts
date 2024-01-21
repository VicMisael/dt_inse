const API_URL = process.env.API_URL || 'http://localhost:8080';


import { InseQueryParams, InseData } from '../types/InseData';

export const fetchInseData = async (params: InseQueryParams): Promise<InseData> => {
  const queryParams = new URLSearchParams();
  Object.entries(params).forEach(([key, value]) => {
    if (value !== undefined) {
      queryParams.set(key, value.toString());
    }
  });

  const response = await fetch(`${API_URL}/inse?${queryParams}`, {
    method: 'GET',
    // Include headers, authentication, etc., if required
  });

  if (!response.ok) {
    throw new Error('Network response was not ok');
  }

  return response.json() as Promise<InseData>;
};

