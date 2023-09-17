import React, { useState, useEffect } from 'react';
import { Text, View, StyleSheet, TouchableOpacity } from 'react-native';
import { BarCodeScanner } from 'expo-barcode-scanner';
import { Alert } from 'react-native'; // Import at the top of your file

export default function BarcodeScanner() {
    const [hasPermission, setHasPermission] = useState(null);
    const [scanned, setScanned] = useState(false);

    useEffect(() => {
        const getBarCodeScannerPermissions = async () => {
            const { status } = await BarCodeScanner.requestPermissionsAsync();
            setHasPermission(status === 'granted');
        };

        getBarCodeScannerPermissions();
    }, []);

    const handleBarCodeScanned = ({ type, data }) => {
        setScanned(true);
        Alert.alert(
            'Success', // Title (left empty for cleaner appearance)
            'Navigate to the "Info" tab to view product data.',
            [
                { text: 'OK', onPress: () => console.log('OK Pressed') }
            ],
            { cancelable: false }
        );
        const url = 'http://192.168.1.30:8080/api/code/' + data;
        fetch(url)
            .then(response => response.json())
            .then(data => {
                console.log(data);
            })
            .catch(error => {

            });
    };

    if (hasPermission === null) {
        return <Text>Requesting for camera permission</Text>;
    }
    if (hasPermission === false) {
        return <Text>No access to camera</Text>;
    }

    return (
        <View style={styles.container}>
            <BarCodeScanner
                onBarCodeScanned={scanned ? undefined : handleBarCodeScanned}
                style={StyleSheet.absoluteFillObject}
            />
            {scanned && (
                <TouchableOpacity style={styles.scanAgainButton} onPress={() => setScanned(false)}>
                    <Text style={styles.scanAgainText}>Tap to Scan Again</Text>
                </TouchableOpacity>
            )}
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'flex-end',
        alignItems: 'center'
    },
    scanAgainButton: {
        marginBottom: 50,
        padding: 15,
        borderRadius: 8,
        backgroundColor: '#2196F3',
        alignItems: 'center'
    },
    scanAgainText: {
        color: 'white',
        fontWeight: 'bold',
        fontSize: 16
    }
});
