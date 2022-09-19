import type { NextPage } from 'next'
import styled from 'styled-components';
import Header from '../components/header';

const SEARCH_RESULTS: NextPage = () => {
    const BACKGROUND = styled.div`
        width: 100%;
        height: 100%;
        background-color: black;
        display:inline-block;
        position: relative;
    `

    const BACKGROUND_IMG = styled.img`
        width: 100%;
        height: 1200px;
        display: inline-block;
        opacity: 1.0;
        object-fit: cover;
    `

    const MAIN_AREA = styled.div`
        width: 800px;
        height: 1100px;
        padding: 20px;
        background-color: white;
        opacity: 1.0;
        position: absolute;
        top: 7%;
        left: 18%;
    `;
    
    const COOK_LIST = styled.div`
        padding: 0;
        height: 1000px;
        margin-top: 30px;
        display: grid;
        grid-template-rows: 260px 260px 260px;
        grid-template-columns: 33.3% 33.3% 33.3%;
        background-color: white;
    `


    const COOK_IMG = styled.img`
        height: 250px;
        width: 200px;
        position: relative;
    `


    return (
        <div>
            <Header />

            <BACKGROUND>
                <BACKGROUND_IMG src='/assets/img/searchResults.jpg'></BACKGROUND_IMG>
                <MAIN_AREA>
                    <COOK_LIST>
                        <div className='cook-img-area-margin'>
                            <div className='cook-img-area'>
                                <COOK_IMG src='/assets/img/tmp/cook1.jpg'></COOK_IMG>
                                <div className='cook-description'>
                                    <div className='cook-caption'>
                                        テスト用料理<br/><br/>
                                        材料：<br/>
                                        じゃがいも<br/>
                                        にんじん....
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div className='cook-img-area-margin'>
                            <div className='cook-img-area'>
                                <COOK_IMG src='/assets/img/tmp/cook2.jpg'></COOK_IMG>
                                <div className='cook-description'>
                                    <div className='cook-caption'>
                                        テスト用料理<br/><br/>
                                        材料：<br/>
                                        じゃがいも<br/>
                                        にんじん....
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div className='cook-img-area-margin'>
                            <div className='cook-img-area'>
                                <COOK_IMG src='/assets/img/tmp/cook3.jpg'></COOK_IMG>
                            </div>
                        </div>

                        <div className='cook-img-area-margin'>
                            <div className='cook-img-area'>
                                <COOK_IMG src='/assets/img/tmp/cook4.jpg'></COOK_IMG>
                            </div>
                        </div>

                        <div className='cook-img-area-margin'>
                            <div className='cook-img-area'>
                                <COOK_IMG src='/assets/img/tmp/cook5.jpg'></COOK_IMG>
                            </div>
                        </div>
                    </COOK_LIST>
                </MAIN_AREA>
            </BACKGROUND>
        </div>
    )
  }
  
  export default SEARCH_RESULTS
  