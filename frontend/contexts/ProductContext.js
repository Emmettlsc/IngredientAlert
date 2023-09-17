import React, { createContext, useState, useContext } from 'react';

const ProductContext = createContext();

export const ProductProvider = ({ children }) => {
    const [productData, setProductData] = useState(null);

    return (
        <ProductContext.Provider value={{ productData, setProductData }}>
            {children}
        </ProductContext.Provider>
    );
}

export const useProduct = () => {
    const context = useContext(ProductContext);
    if (context === undefined) {
        throw new Error('useProduct must be used within a ProductProvider');
    }
    return context;
};
