// components/InseDataTable.tsx
import React from 'react';
import { InseItem } from '../types/InseData';

interface InseDataTableProps {
  data: InseItem[];
}

const InseDataTable: React.FC<InseDataTableProps> = ({ data }) => {
  const renderTableRows = (items: InseItem[]) => {
    return items.map((item, index) => (
      <tr key={index} className="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
        <td className="">{item.AnoSaeb}</td>
        <td className="">{item.CodUF}</td>
        <td className="">{item.NomeUF}</td>
        <td className="">{item.CodMunicipio}</td>
        <td className="">{item.NomeMunicipio}</td>
        <td className="">{item.IdEscola}</td>
        <td className="">{item.NomeEscola}</td>
        <td className="">{item.tipoRede}</td>
        <td className="">{item.tipoLocalizacao}</td>
        <td className="">{item.tipoCapital}</td>
        <td className="">{item.QtdAlunos}</td>
        <td className="">{item.MediaInse}</td>
        <td className="">{item.InseClassificacao}</td>
        <td className="">{item.PorcentagemNivel1}</td>
        <td className="">{item.PorcentagemNivel2}</td>
        <td className="">{item.PorcentagemNivel3}</td>
        <td className="">{item.PorcentagemNivel4}</td>
        <td className="">{item.PorcentagemNivel5}</td>
        <td className="">{item.PorcentagemNivel6}</td>
        <td className="">{item.PorcentagemNivel7}</td>
        <td className="">{item.PorcentagemNivel8}</td>
      </tr>
    ));
  };

  return (
    <div className="overflow-x-auto relative shadow-md sm:rounded-lg">
      <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
        <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
          <tr>
            <th scope="col" className="py-3 px-6">Ano Saeb</th>
            <th scope="col" className="py-3 px-6">Cod UF</th>
            <th scope="col" className="py-3 px-6">Nome UF</th>
            <th scope="col" className="py-3 px-6">Cod Municipio</th>
            <th scope="col" className="py-3 px-6">Nome Municipio</th>
            <th scope="col" className="py-3 px-6">Id Escola</th>
            <th scope="col" className="py-3 px-6">Nome Escola</th>
            <th scope="col" className="py-3 px-6">Tipo Rede</th>
            <th scope="col" className="py-3 px-6">Tipo Localizacao</th>
            <th scope="col" className="py-3 px-6">Tipo Capital</th>
            <th scope="col" className="py-3 px-6">Quantidade Alunos</th>
            <th scope="col" className="py-3 px-6">Media INSE</th>
            <th scope="col" className="py-3 px-6">Classificação INSE</th>
            <th scope="col" className="py-3 px-6">Porcentagem Nivel 1</th>
            <th scope="col" className="py-3 px-6">Porcentagem Nivel 2</th>
            <th scope="col" className="py-3 px-6">Porcentagem Nivel 3</th>
            <th scope="col" className="py-3 px-6">Porcentagem Nivel 4</th>
            <th scope="col" className="py-3 px-6">Porcentagem Nivel 5</th>
            <th scope="col" className="py-3 px-6">Porcentagem Nivel 6</th>
            <th scope="col" className="py-3 px-6">Porcentagem Nivel 7</th>
            <th scope="col" className="py-3 px-6">Porcentagem Nivel 8</th>
          </tr>
        </thead>
        <tbody>
          {renderTableRows(data)}
        </tbody>
      </table>
    </div>
  );
};

export default InseDataTable;
