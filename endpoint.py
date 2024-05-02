from flask import Flask, request, jsonify
from joblib import load
import sqlite3
import numpy as np
from sklearn.preprocessing import MinMaxScaler

app = Flask(__name__)

# Load the pre-trained SVM model
svm_loaded = load('svm_model.joblib')

@app.route('/')
def index():
    """
    Display a welcome message for the Device Classification System.

    Returns:
        str: A welcome message.
    """
    return "Welcome to Device Classification System, Please Provide Your Device specs to predict the Device Price"

@app.route('/predict/<int:id>', methods=['POST'])
def predict(id):
    """
    Predict the price of a device based on its specifications.

    Args:
        id (int): The ID of the device to predict its price.

    Returns:
        dict: A JSON object containing the predicted price.
    """
    # Connect to the SQLite database
    conn = sqlite3.connect('Dataset/test-test.db')
    cursor = conn.cursor()

    # Query the database to get the record for the specified device ID
    cursor.execute(f"SELECT * FROM devices WHERE id = {id}")
    record = cursor.fetchone()

    # Close the database connection
    conn.close()

    if record is None:
        # If no device with the specified ID is found, return a 404 error
        return jsonify({'error': 'Device not found'}), 404
    else:
        # Prepare the record for prediction
        record = record[1:]  # Exclude the ID column
        record = np.array([record])  # Convert to a 2D NumPy array
        # Connect to the SQLite database again to retrieve all data
        conn = sqlite3.connect('Dataset/test-test.db')
        cursor = conn.cursor()


        cursor.execute("SELECT * FROM devices")
        all_records = cursor.fetchall()

        # Close the database connection
        conn.close()
        all_records = np.array([record[1:] for record in all_records])

        # Define the MinMaxScaler
        scaler = MinMaxScaler()
        scaler.fit(all_records)
        normalized_record = scaler.transform(record)

        # Use the loaded SVM model to predict the price
        price = svm_loaded.predict(normalized_record)

        # Return the predicted price as a JSON response
        return jsonify({'price': price.tolist()})
    
if __name__ == '__main__':
    app.run(debug=True)
