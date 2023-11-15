// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration, log into Firebase and get the config settings under project settings
const firebaseConfig = {
    apiKey: "REPLACE THIS",
    authDomain: "REPLACE THIS",
    projectId: "REPLACE THIS",
    storageBucket: "REPLACE THIS",
    messagingSenderId: "REPLACE THIS",
    appId: "REPLACE THIS"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);

export default app;