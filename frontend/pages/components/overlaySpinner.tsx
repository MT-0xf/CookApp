import { NextPage } from "next";

export const OverlaySpinner: NextPage = () => {
    return (
      <div className="overlay">
        <div className="spinner"></div>
      </div>
    );
  };