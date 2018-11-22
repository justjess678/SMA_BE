# -*- coding: utf-8 -*-
"""
Created on Wed Nov 21 22:19:34 2018

@author: jess
"""

import numpy as np
import matplotlib.pyplot as plt

H = np.loadtxt("brightness.txt")
x, y = np.hsplit(H,2)
fig1, ax1 = plt.subplots()
ax1.plot(x, y)
ax1.set_title("Brightness")
ax1.set_xlabel("Time")
ax1.set_ylabel("Brightness (%)")

H = np.loadtxt("energy.txt")
x, y = np.hsplit(H,2)
fig2, ax2 = plt.subplots()
ax2.plot(x, y)
ax2.set_title("Energy Consumption")
ax2.set_xlabel("Time")
ax2.set_ylabel("Energy consumed (Watts)")