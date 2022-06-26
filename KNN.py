# Import necessary modules
from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import train_test_split
from sklearn.datasets import load_iris
import pandas as pd
import numpy as np







# from google.colab import drive
# drive.mount('/content/drive', force_remount=True)
#
# %cd /content/drive/MyDrive/TEMP






datas = pd.read_csv("diabetes.csv")
df = pd.DataFrame(datas)
df2 = pd.DataFrame(datas)

npy = df.to_numpy()

# X = df.drop(["Outcome"], axis = 1)
# y = df2.drop(["Glucose", "BloodPressure", "Insulin", "BMI", "DiabetesPedigreeFunction", "Age", "SkinThickness"],  axis = 1)

X = np.delete(npy, 7, 1)
y = np.delete(npy, [0,1,2,3,4,5,6], 1)




X_train, X_test, y_train, y_test = train_test_split( X, y, test_size = 0.2, random_state=0)
knn = KNeighborsClassifier(n_neighbors=7)

knn.fit(X_train, y_train)




a = knn.predict(X_test)
print(a)