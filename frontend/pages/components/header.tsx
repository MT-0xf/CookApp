import type { NextPage } from 'next'
import Link from 'next/link';
import { useEffect, useState } from 'react'

export const Header: NextPage = () => {
  const [width, setWidth] = useState(0);  
  useEffect(() => {
      setWidth(window.innerWidth);  
  },[]);

  return (
    <div>
      <div className="header">
        { width < 1020 ? 
            <div className="header-left">
              <Link href="/">CookApp</Link>
            </div>
            :
            <div className="header-left">
              <Link href="/">料理を通じて暮らしを豊かに</Link>
            </div>
        }
        
        <div className="header-right">
          <div className="header-right-item">
            <Link href="recipe-register">レシピをつくる</Link>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Header
