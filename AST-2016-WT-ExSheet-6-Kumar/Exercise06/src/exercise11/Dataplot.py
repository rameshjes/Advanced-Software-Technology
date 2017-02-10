#!/usr/bin/env python
import numpy as np
import matplotlib.pyplot as plt

data = np.loadtxt("/home/ramesh/workspace/Exercise11/src/samples")
plt.scatter(data[:,0], data[:,1])