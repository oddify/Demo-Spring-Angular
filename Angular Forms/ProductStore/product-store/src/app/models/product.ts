export interface IProduct {
  id: number;
  name: string;
  description: string;
  price: number;
  quantity: number;
  imageUrl: string;
  category: ICategory;
}

export interface ICategory {
  name: string;
}
