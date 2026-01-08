# HealthGPT

HealthGPT is a modern Android application designed to provide users with a health-focused conversational AI experience. It features a clean, intuitive chat interface that allows users to interact with a backend-driven AI assistant to get health-related information and support.

## 🚀 Features

*   **Real-time Chat Interface:** Seamlessly send and receive messages with a smooth UI.
*   **AI Integration:** Connects to a dedicated health-focused GPT backend for intelligent responses.
*   **Modern UI/UX:** Uses Material Design components and custom message bubbles for a polished look.
*   **Robust Networking:** Built with Retrofit and Gson for reliable API communication.

## 🛠 Tech Stack

*   **Language:** Kotlin
*   **UI Framework:** Android XML (View-based) with Material Components
*   **Networking:** [Retrofit](https://square.github.io/retrofit/) & [Gson](https://github.com/google/gson)
*   **Concurrency:** Callbacks (Retrofit)
*   **List Handling:** RecyclerView with a custom adapter

## 📦 Project Structure

*   `MainActivity.kt`: The main entry point handling the chat UI and network calls.
*   `adapter/ChatAdapter.kt`: Manages the display of chat messages in the list.
*   `model/Message.kt`: Data class for chat messages.
*   `network/ApiService.kt`: Defines the Retrofit API interface for backend communication.
*   `res/drawable/`: Contains custom drawables for message bubbles (`bot_bubble.xml`, `input_bg.xml`, etc.).

## ⚙️ Setup & Installation

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/yourusername/HealthGPT.git
    ```
2.  **Open in Android Studio:**
    Open the project folder in the latest version of Android Studio.
3.  **Sync Gradle:**
    Wait for the Gradle sync to complete and download all dependencies.
4.  **Run the App:**
    Connect an Android device or start an emulator and click the **Run** button.

## 🔗 Backend API

The app currently connects to a backend service hosted on Render:
`https://health-gpt-9zpw.onrender.com/`

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.
