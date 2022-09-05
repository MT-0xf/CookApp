export interface User {
  id: number;
  name: string;
  password: string;
}

export interface UserData {
  users: User[];
}

export interface RecipeData {
  recipe_id: number;
  dish_name: string;
  ingredients: Ingredient[];
  procedures: Procedure[];
}

export interface Ingredient {
  recipe_id: number;
  ingredient_id: number;
  ingredient_name: string;
  amount: string;
}

export interface Procedure {
  recipe_id: number;
  order: number;
  method: string;
  img: string;
}