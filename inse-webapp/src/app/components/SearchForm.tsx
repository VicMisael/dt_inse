// components/SearchForm.tsx
import React, { useState } from 'react';
import { InseQueryParams } from '../types/InseData';

interface SearchFormProps {
  onSearch: (params: InseQueryParams) => void;
}

const SearchForm: React.FC<SearchFormProps> = ({ onSearch }) => {
  const [localParams, setLocalParams] = useState<InseQueryParams>({});

  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
    setLocalParams({ ...localParams, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    onSearch(localParams);
  };

  return (
    <form  onSubmit={handleSubmit} className="flex items-stretch text-black">
      <div>
        <label htmlFor="querySchoolName">School Name:</label>
        <input type="text" id="querySchoolName" name="querySchoolName" onChange={handleChange} placeholder="School Name" className="border px-2 py-1" />
      </div>

      <div className="flex flex-col">
        <label htmlFor="uf" className="mb-2 font-semibold">UF:</label>
        <input type="text" id="uf" name="uf" onChange={handleChange} placeholder="UF" className="border px-2 py-1 rounded" />
      </div>

      <div className="flex flex-col">
        <label htmlFor="municipio" className="mb-2 font-semibold">Municipio:</label>
        <input type="text" id="municipio" name="municipio" onChange={handleChange} placeholder="Municipio" className="border px-2 py-1 rounded" />
      </div>

      <div>
        <label htmlFor="orderMediaInse">Order by Media INSE:</label>
        <select id="orderMediaInse" name="orderMediaInse" onChange={handleChange} className="border px-2 py-1">
          <option value="">Select</option>
          <option value="Asc">Ascending</option>
          <option value="Desc">Descending</option>
        </select>
      </div>

      <div>
        <label htmlFor="orderUf">Order by UF:</label>
        <select id="orderUf" name="orderUf" onChange={handleChange} className="border px-2 py-1">
          <option value="">Select</option>
          <option value="Asc">Ascending</option>
          <option value="Desc">Descending</option>
        </select>
      </div>

      <div>
        <label htmlFor="orderMunicipio">Order by Municipio:</label>
        <select id="orderMunicipio" name="orderMunicipio" onChange={handleChange} className="border px-2 py-1">
          <option value="">Select</option>
          <option value="Asc">Ascending</option>
          <option value="Desc">Descending</option>
        </select>
      </div>

      <div>
        <label htmlFor="orderBySchoolName">Order by School Name:</label>
        <select id="orderBySchoolName" name="orderBySchoolName" onChange={handleChange} className="border px-2 py-1">
          <option value="">Select</option>
          <option value="Asc">Ascending</option>
          <option value="Desc">Descending</option>
        </select>
      </div>

      <button type="submit" className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
        Search
      </button>
    </form>
  );
};

export default SearchForm;
