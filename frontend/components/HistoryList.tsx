import React from 'react';
import { FlatList, View } from 'react-native';
import HistoryItem from './HistoryItem';
import mockData from '../data/mockDataOld.json';

const HistoryList = ({ onItemPress }) => {
    const renderItem = ({ item }) => (
        <HistoryItem product={item} onPress={() => onItemPress(item)} />
    );

    return (
        <View style={{ flex: 1 }}>
            <FlatList
                data={Array(1).fill(mockData.product)} //repeats the mockData 20 times for demonstration
                renderItem={renderItem}
                keyExtractor={(item, index) => index.toString()}
            />
        </View>
    );
};

export default HistoryList;
