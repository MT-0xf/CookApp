import type { NextPage } from 'next'
import styled from 'styled-components';
import Header from '../components/header'

const SEARCH_DETAIL: NextPage = () => {

    const BACKGROUND = styled.div`
        width: 100%;
        height: 100%;
        background-color: black;
        display:inline-block;
        position: relative;
    `

    const BACKGROUND_IMG = styled.img`
        width: 100%;
        height: 2000px;
        display: inline-block;
        opacity: 1.0;
        object-fit: cover;
    `

    const MAIN_AREA = styled.div`
        width: 800px;
        height: 1800px;
        padding: 20px;
        background-color: white;
        opacity: 1.0;
        position: absolute;
        top: 7%;
        left: 18%;
    `;

    const COOK_IMG = styled.img`
        width: 300px;
        height: 300px;
        object-fit: cover;
    `

    const COOK_FLEX = styled.div`
        display: flex;
        justify-content: space-between;
    `

    const COOK_OVERVIEW = styled.div`
        height: 300px;
        width: 58%;
        background-color: #f5f6f2;
        padding: 15px;
    `

    const COOK_DETAIL = styled.div`
        height: 1400px;
        background-color: #f5f6f2;
        padding: 30px;
        margin: 15px 0px; 15px 0px;
    `

    const COOK_PROCEDURE = styled.div`
        padding: 0;
        margin-top: 30px;
        display: grid;
        grid-template-rows: 400px 400px 400px;
        grid-template-columns: 33.3% 33.3% 33.3%;
    `

    const COOK_PROCEDURE_IMG = styled.img`
        width: 200px;
        height: 200px;
        object-fit: cover;
    `

    const COOK_PROCEDURE_TXT = styled.div`
        width: 200px;
    `

    return (
        <div>
            <Header />
            <BACKGROUND>
                <BACKGROUND_IMG src='/assets/img/searchDetail.jpg'></BACKGROUND_IMG>
                <MAIN_AREA>
                    <COOK_FLEX>
                        <COOK_IMG src='/assets/img/tmp/cook1.jpg'></COOK_IMG>
                        <COOK_OVERVIEW>
                            <h1>美味しいケーキ</h1>
                            <h2>原材料</h2>
                            <div>スポンジケーキ、生クリーム、果物</div>
                        </COOK_OVERVIEW>
                    </COOK_FLEX>
                    <COOK_DETAIL>
                        <h1>調理手順</h1>
                        <COOK_PROCEDURE>
                            <div>
                                <COOK_PROCEDURE_IMG src='/assets/img/tmp/cook2.jpg'></COOK_PROCEDURE_IMG>
                                <h2>1.</h2>
                                <COOK_PROCEDURE_TXT>
                                    調理手順の説明が入ります。具体的な内容に関してはサーバからのレスポンスから取得します。
                                </COOK_PROCEDURE_TXT>
                            </div>


                            <div>
                                <COOK_PROCEDURE_IMG src='/assets/img/tmp/cook3.jpg'></COOK_PROCEDURE_IMG>
                                <h2>2.</h2>
                                <COOK_PROCEDURE_TXT>
                                    調理手順の説明が入ります。具体的な内容に関してはサーバからのレスポンスから取得します。
                                </COOK_PROCEDURE_TXT>
                            </div>

                            <div>
                                <COOK_PROCEDURE_IMG src='/assets/img/tmp/cook4.jpg'></COOK_PROCEDURE_IMG>
                                <h2>3.</h2>
                                <COOK_PROCEDURE_TXT>
                                    調理手順の説明が入ります。具体的な内容に関してはサーバからのレスポンスから取得します。
                                </COOK_PROCEDURE_TXT>
                            </div>

                            <div>
                                <COOK_PROCEDURE_IMG src='/assets/img/tmp/cook5.jpg'></COOK_PROCEDURE_IMG>
                                <h2>4.</h2>
                                <COOK_PROCEDURE_TXT>
                                    調理手順の説明が入ります。具体的な内容に関してはサーバからのレスポンスから取得します。
                                </COOK_PROCEDURE_TXT>
                            </div>

                            <div>
                                <COOK_PROCEDURE_IMG src='/assets/img/tmp/cook5.jpg'></COOK_PROCEDURE_IMG>
                                <h2>5.</h2>
                                <COOK_PROCEDURE_TXT>
                                    調理手順の説明が入ります。具体的な内容に関してはサーバからのレスポンスから取得します。
                                </COOK_PROCEDURE_TXT>
                            </div>
                        </COOK_PROCEDURE>
                    </COOK_DETAIL>
                </MAIN_AREA>
            </BACKGROUND>


        </div>
    )
  }
  
  export default SEARCH_DETAIL
  