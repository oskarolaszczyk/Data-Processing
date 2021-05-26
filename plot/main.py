import matplotlib.pyplot as plt
import ast


with open('../data_processing/result.txt', 'r') as file:
    title = file.readline()
    text = file.readline()
    post_score = int(file.readline())
    avg_score = float(file.readline())
    neigh_scores = ast.literal_eval(file.readline())

x = [i for i in range(2, len(neigh_scores)+2)]

ps = plt.bar(0 ,post_score, label='post score', width=0.25)
avg = plt.bar(1, avg_score, label='avg neighbors score', width=0.25)


plt.ylabel("score")
plt.title(title)
plt.xticks([])
plt.legend(fontsize=13)

plt.show()

ps2 = plt.bar(0, post_score, label='post score')
avg2 = plt.bar(1, avg_score, label='avg neighbors score')
neigh = plt.bar(x, neigh_scores, label='neighbors scores')


plt.ylabel("score")
plt.title(title)
plt.xticks([])
plt.legend(fontsize=13)

plt.show()
