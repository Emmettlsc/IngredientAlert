import React from 'react';
import { StyleSheet } from 'react-native';
import { Text, View } from '../../components/Themed';
import HistoryList from '../../components/HistoryList';
import { ProductProvider } from '../../contexts/ProductContext';

export default function History() {

    const handleItemPress = (product: { name: any; }) => {
        //handle item click here by naving to item page
        console.log(product.name);
    };

    return (
        <View style={styles.container}>
            <HistoryList onItemPress={handleItemPress} />
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
    },
    title: {
        fontSize: 20,
        fontWeight: 'bold',
        textAlign: 'center',
        marginTop: 20
    },
    separator: {
        marginVertical: 30,
        height: 1,
        width: '80%',
        alignSelf: 'center'
    },
});
