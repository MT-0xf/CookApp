import { useMutation } from "@apollo/client";
import React, { useEffect, useState } from "react";
import { REGISTER_RECIPE } from "../../graphql/queries/mutation";
import { InputCookProcedure, InputCreateRecipe, InputIngrediet } from "../../graphql/types/types";
import { CookProcedure, Ingredient } from "../types/types";
import { OverlaySpinner } from "./overlaySpinner";


export const RecipeRegisterForm = () => {

    const [recipeName, setRecipeName] = useState<string>("");
    const [recipeImg, setRecipeImg] = useState<string>("");
    const [recipeImgFileName, setRecipImgFileName] = useState<string>("");
    const [ingredients, setIngredients] = useState<Ingredient[]>([]);
    const [ingredientsNumber, setIngredientsNumber] = useState<number>(0);
    const [cookProcedures, setCookProcedures] = useState<CookProcedure[]>([]);
    const [ isLoading, setIsLoading ] = useState(false);

    const [addRecipe, { loading, error }] = useMutation(REGISTER_RECIPE);

    const changeRecipeName = (e: any) => {
        e.preventDefault();
        setRecipeName(e.target.value)
    }

    const changeRecipeImg = (e: any) => {
        var image = e.target.files[0];
        setRecipImgFileName(image.fileName);
        var fileReader = new FileReader();
        fileReader.readAsDataURL(image);
        
        fileReader.onload = function () {
            if (fileReader.result != null) {
                setRecipeImg(fileReader.result.toString());
            }
        }
    }

    const addIngredient = () => {
        let newIngredient: Ingredient = {
            id: ingredients.length + 1,
            ingredientName: "",
            amount: ""
        }

        let newIngredients = [...ingredients, newIngredient]
        setIngredients(newIngredients);
    }

    const removeIngredient = (e: any, index: number) => {
        let newIngredients = [...ingredients];
        newIngredients = newIngredients.filter(ingredient => {
            return ingredient.id != index + 1;
        });

        let results: Ingredient[] = [];

        newIngredients.forEach((ingredient, index) => {
            ingredient.id = index + 1;
            results.push(ingredient);
        })

        setIngredients(results);
    }

    const changeIngredientName = (e: any, index: number) => {
        e.preventDefault();
        const newIngredients = [...ingredients];
        newIngredients[index].ingredientName = e.target.value;
        setIngredients(newIngredients);
    }

    const changeAmount = (e: any, index: number) => {
        e.preventDefault();
        const newIngredients = [...ingredients];
        newIngredients[index].amount = e.target.value;
        setIngredients(newIngredients);
    }

    const addCookProcedure = () => {
        let newCookProcedure: CookProcedure = {
            orderNumber: cookProcedures.length + 1,
            img: "",
            imgFileName: "",
            method: ""
        }

        let newCookProcedures = [...cookProcedures, newCookProcedure]
        setCookProcedures(newCookProcedures);
    }

    const removeCookProcedure = (e: any, index: number) => {
        let newCookProcedures = [...cookProcedures];
        newCookProcedures = newCookProcedures.filter(cookProcedure => {
            return cookProcedure.orderNumber != index + 1;
        });

        let results: CookProcedure[] = [];

        newCookProcedures.forEach((cookProcedure, index) => {

            cookProcedure.orderNumber = index + 1;
            results.push(cookProcedure);
        })

        setCookProcedures(results);
    }

    const changeCookProcedureImg = (e: any, index: number) => {
        e.preventDefault();
        let image = e.target.files[0];

        const newCookProcedures = [...cookProcedures];
        newCookProcedures[index].imgFileName = image.fileName;
        console.log(newCookProcedures[index]);
        let fileReader = new FileReader();
        fileReader.readAsDataURL(image);
        setCookProcedures(newCookProcedures);
        
        fileReader.onload = function () {
            if (fileReader.result != null) {
                newCookProcedures[index].img = fileReader.result.toString()
                setCookProcedures(newCookProcedures);
            }
        }
    }

    const changeMethod = (e: any, index: number) => {
        e.preventDefault();
        const newCookProcedures = [...cookProcedures];
        newCookProcedures[index].method = e.target.value;
        setCookProcedures(newCookProcedures);
    }

    const validate = () => {

        if (recipeName == "") {
            return "????????????????????????????????????";
        }

        if (recipeName.length > 45) {
            return "????????????45???????????????????????????????????????";
        }

        if (recipeImg == "") {
            return "???????????????????????????????????????";
        }

        for (let i=0; i<ingredients.length; i++) {
            if (ingredients[i].ingredientName == "") {
                return "????????????????????????????????????????????????";
            }

            if (ingredients[i].ingredientName.length > 45) {
                return "????????????45???????????????????????????????????????";
            }

            if (ingredients[i].amount == "") {
                return "?????????????????????????????????????????????";
            }

            if (ingredients[i].amount.length > 45) {
                return "?????????45???????????????????????????????????????";
            }
        }

        for (let i=0; i<cookProcedures.length; i++) {
            if (cookProcedures[i].img == "") {
                return "???????????????????????????????????????????????????";
            }

            if (cookProcedures[i].method == "") {
                return "???????????????????????????????????????????????????";
            }

            if (cookProcedures[i].method.length > 200) {
                return "???????????????200???????????????????????????????????????";
            }
        }

        return "OK";
    }

    const registerRecipe = () => {

        let msg = validate();

        if (msg != "OK") {
            alert(msg);
            return;
        }

        let inputIngredients: InputIngrediet[] = [];
        for (let i=0; i<ingredients.length; i++) {
            let inputIngredient: InputIngrediet = {
                ingredientId: "",
                ingredientName: ingredients[i].ingredientName,
                amount: ingredients[i].amount,
                recipeId: ""
            }
            inputIngredients.push(inputIngredient);
        }

        let inputProcedures: InputCookProcedure[] = [];
        for (let i=0; i<cookProcedures.length; i++) {
            let inputProcedure: InputCookProcedure = {
                recipeId: "",
                orderNumber: cookProcedures[i].orderNumber,
                img: cookProcedures[i].img,
                method: cookProcedures[i].method,
            }
            inputProcedures.push(inputProcedure);
        }

        let data: InputCreateRecipe = {
            recipeData: {
                recipeId: "",
                dishName: recipeName,
                img: recipeImg
            },
            ingredients: inputIngredients,
            procedures: inputProcedures
        }

        let res = addRecipe({ variables: { inputCreateRecipe: data } });
        let resMsg: string = "";

        setIsLoading(true);

        res.then(value => {

            if (!value) {
                resMsg = "????????????????????????????????????";
            } else {
                resMsg = "??????????????????????????????";
            }

            setIsLoading(false);
            alert(resMsg);
        });
    }

    useEffect(() => {

        if (ingredientsNumber < ingredients.length){
            let inputForm = document.getElementById("ingredient" + (ingredientsNumber + 1));
            if (inputForm) {
                let inputFormHeight = inputForm.scrollHeight;
                inputForm.scrollTop = inputFormHeight;
            }    
        }
        
        setIngredientsNumber(ingredients.length);
    },[ingredients.length]);

    return (
        <div className="recipe-recipe-register-input-form-wrap">
            <div id="input-form" className="recipe-register-input-form scroll">
                <h1>???????????????</h1>
                <input type="text" className="recipe-register-input-text" placeholder="?????????" maxLength={45} value={recipeName} onChange={changeRecipeName}></input><br/>

                <div className="recipe-register-input-label">????????????</div>
                <input type="file" accept="image" value={recipeImgFileName} onChange={changeRecipeImg}></input><br/>

                <h1>??????</h1>
                <div>
                    {ingredients.map((ingredient, index) => (
                        <div key={"ingredient" + index} id={"ingredient" + index} className="ingredients-flex">
                            <input className="input-text-ingredient" type="text" placeholder="??????" maxLength={45} onChange={(e) => changeIngredientName(e, index)}></input>
                            <input className="input-text-amount" type="text" placeholder="??????" maxLength={45} value={ingredient.amount} onChange={(e) => changeAmount(e, index)}></input>
                            <div className="ingredient-remove-button-area" onClick={(e) => removeIngredient(e, index)}>
                                <span className="dli-close"></span>
                            </div>
                        </div>
                    ))}

                    <div className="ingredient-plus-area">
                        <div id="plus-ingredient" className="ingredient-add-button-area" onClick={addIngredient}>
                            <div className="dli-plus"></div>
                        </div>
                        <div className="ingredient-add-label" onClick={addIngredient}>???????????????</div>
                    </div>
                </div>

                <h1>????????????</h1>
                <div>
                    {cookProcedures.map((cookProcedure, index) => (
                        <div key={"cookProcedure" + index}>
                            <div className="cook-procedure-flex">
                                <h2>??????{cookProcedure.orderNumber}</h2>
                                <div className="cook-procedure-remove" onClick={(e) => removeCookProcedure(e, index)}>
                                    <div className="dli-close"></div>
                                </div>
                            </div>
                            <div className="recipe-register-input-label">????????????</div>
                            <input type="file" value={cookProcedure.imgFileName} onChange={(e) => changeCookProcedureImg(e, index)}></input>
                            <textarea className="cookprocedure-textarea" placeholder="????????????" maxLength={200} value={cookProcedure.method} onChange={(e) => changeMethod(e, index)}></textarea>
                        </div>
                    ))}

                    <div className="cook-procedure-plus-area">
                        <div id="plus-cook-procedure" className="cook-procedure-add-button-area" onClick={addCookProcedure}>
                            <div className="dli-plus"></div>
                        </div>
                        <div className="cook-procedure-add-label" onClick={addCookProcedure}>?????????????????????</div>
                    </div>
                </div>
            </div>

            <div className="recipe-register-send-button">
                <input className="recipe-register-button-color recipe-register-button-radius" type="button" value="????????????" onClick={registerRecipe}></input>
            </div>

            {isLoading && <OverlaySpinner />}
        </div>
    )
}

export default RecipeRegisterForm

