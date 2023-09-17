//https://docs.expo.dev/versions/latest/sdk/camera/
import React, { useState, useRef } from 'react';
import { View, Text, Button, TouchableOpacity, StyleSheet } from 'react-native';
import { Camera, CameraType } from 'expo-camera';
import Uri from "ajv/lib/runtime/uri";

export default function FoodCamera() {
    const [type, setType] = useState(CameraType.back);
    const [mode, setMode] = useState("ingredients");  //new state for mode
    const [permission, requestPermission] = Camera.useCameraPermissions();

    const cameraRef = useRef<Camera | null>(null); //reference to the Camera component

    if (!permission) {
        return <View />;
    }

    if (!permission.granted) {
        return (
            <View style={styles.container}>
                <Text style={{ textAlign: 'center' }}>We need your permission to show the camera</Text>
                <Button onPress={requestPermission} title="Grant Permission" />
            </View>
        );
    }

    async function captureImage() {
        if (cameraRef.current) {
            const photo = await cameraRef.current.takePictureAsync();
            const barcode = 0;
            const url = 'https://your-spring-boot-api-endpoint/api/code' + barcode;
            //Barcode extracted from photo above
            fetch(url)
                .then(response => response.json())
                .then(data => {
                    //go into history database
                    //show on screen
                })
                .catch(error => {
                    // Handle any errors that occurred during the request
                });

            //can use this `photo` object to send to server
            console.log(photo.uri);
        }
    }

    return (
        <View style={styles.container}>
            <Camera style={styles.camera} type={type} ref={cameraRef}>

                {/* Toggle Buttons */}
                <View style={styles.toggleContainer}>
                    <TouchableOpacity
                        style={[styles.button, mode === "ingredients" ? styles.selectedButton : null]}
                        onPress={() => setMode("ingredients")}
                    >
                        <Text style={styles.text}>Ingredients</Text>
                    </TouchableOpacity>
                    <TouchableOpacity
                        style={[styles.button, mode === "label" ? styles.selectedButton : null]}
                        onPress={() => setMode("label")}
                    >
                        <Text style={styles.text}>Label</Text>
                    </TouchableOpacity>
                    <TouchableOpacity
                        style={[styles.button, mode === "barcode" ? styles.selectedButton : null]}
                        onPress={() => setMode("barcode")}
                    >
                        <Text style={styles.text}>Barcode</Text>
                    </TouchableOpacity>
                </View>

                {/* Capture Button */}
                <View style={styles.captureContainer}>
                    <TouchableOpacity style={styles.button} onPress={captureImage}>
                        <Text style={styles.text}>Capture</Text>
                    </TouchableOpacity>
                </View>

            </Camera>
        </View>
    );
}


const styles = StyleSheet.create({
    container: {
        flex: 1,
    },
    camera: {
        flex: 1,
    },
    toggleContainer: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center',
        // backgroundColor: 'rgba(0,0,0,0.5)',
        paddingHorizontal: 15,
        paddingVertical: 5,
        position: 'absolute',
        top: 20,
        left: 10,
        right: 10,
        borderRadius: 15,
    },
    captureContainer: {
        justifyContent: 'center',
        alignItems: 'center',
        // backgroundColor: 'rgba(0,0,0,0.5)',
        paddingHorizontal: 20,
        paddingVertical: 5,
        position: 'absolute',
        bottom: 20,
        left: '34%',
        borderRadius: 15,
    },
    button: {
        padding: 8,
        alignItems: 'center',
        borderRadius: 8,
        borderWidth: 1,
        borderColor: 'white',
    },
    selectedButton: {
        backgroundColor: 'rgba(255,255,255,0.2)',
    },
    text: {
        fontSize: 14,
        fontWeight: 'bold',
        color: 'white',
    },
});


