// components/AggregationComponent.tsx
import React from 'react';
import { InseAverages } from '../types/InseData';


interface AggregationComponentProps {
  data: InseAverages;
}

const AggregationComponent: React.FC<AggregationComponentProps> = ({ data }) => {
  return (
    <div className="bg-white  text-black shadow-md rounded px-8 pt-6 pb-8 mb-4">
      <h2 className="text-xl font-semibold mb-4">Aggregation Data</h2>
      <div className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
      <h2 className="text-xl font-semibold mb-4">Aggregation Data</h2>
      <div>Total Students: {data.QtdAlunos}</div>
      <div>Average INSE: {data.MediaInse}</div>
      <div>Percentage Level 1: {data.PorcentagemNivel1}%</div>
      <div>Percentage Level 2: {data.PorcentagemNivel2}%</div>
      <div>Percentage Level 3: {data.PorcentagemNivel3}%</div>
      <div>Percentage Level 4: {data.PorcentagemNivel4}%</div>
      <div>Percentage Level 5: {data.PorcentagemNivel5}%</div>
      <div>Percentage Level 6: {data.PorcentagemNivel6}%</div>
      <div>Percentage Level 7: {data.PorcentagemNivel7}%</div>
      <div>Percentage Level 8: {data.PorcentagemNivel8}%</div>
    </div>
    </div>
  );
};

export default AggregationComponent;
