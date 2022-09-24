export interface User {
  id: number;
  name: string;
  password: string;
}

export interface UserData {
  users: User[];
}

export type InputCreateRecipe = {
  recipeData: InputRecipeData;
  ingredients: InputIngrediet[];
  procedures: InputCookProcedure[];

}

export type InputRecipeData = {
  recipeId: string;
  dishName: string;
  img: string;
}

export type InputIngrediet = {
  recipeId: string;
  ingredientId: string;
  ingredientName: string;
  amount: string;
}

export type InputCookProcedure = {
  recipeId: string;
  orderNumber: number;
  method: string;
  img: string;
}