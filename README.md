# IngredientAlert User Guide

## Prerequisites: 

- Install Expo Go on mobile (App Store)
- Clone repo, and nagivate to the frontend directory
- Run backend seperately on the same device (build gradle first)

### Mobile App:
Install expo go cli globally: 

```npm install -g expo-cli```

Run the app/project: 

```npm start```

To view in emulator, have emulator running then type "a" for android or "i" for iphone in cli, expo go will find the emulator and run the project. 

Device URL needs to be manually set, so once you receive IP information from running the project, head over to frontend > components > BarcodeScanner.tsx and edit the url variable.

Scan the QR code with Phone Camera. Once prompted to Expo Po app, it will ask for Camera permissions, enable and start scanning for Barcodes.

Once scanned, a valid product would list the information on screen, including if there are any dangerous ingredients detected.

To scan again, tap the "Tap to Scan Again" button on your phone. 

History of scans completion TBD

### Backend

Make sure Backend is running at the same time as the frontend, your port is most likely 8080


**There might be some uncaught errors in case the product that is scanned is missing fields in the OpenFoodFacts database.**
