'use client'
import Image from "next/image";
import InsePage from "./components/InsePage";


export default function Home() {
  return (
    <div className="bg-white container mx-auto p-4">
      <h1>Welcome to the INSE Data Application</h1>
      <InsePage />
    </div>
  );
}
