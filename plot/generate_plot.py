import pandas as pd


def generate_plot(json_file_path, out_file_name, ylim=(9, 14)):
    try:
        df = pd.read_json(json_file_path, orient='index')
    except:
        import json
        with open(json_file_path) as f:
            data = json.load(f)
            df = pd.DataFrame(data)

    week_days = ('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday')

    for week_day, i in zip(week_days, range(7)):
        df[week_day] = df[0].loc[list(range(i * 24, (i + 1) * 24))]

    my_colors = ['b', 'r', 'g', 'y', 'k', 'c', 'm']
    plot = (df.drop(columns=[0])
            .plot(kind='bar', figsize=(20, 8),
                  ylim=ylim, xticks=list(range(0, 167, 5)),
                  color=my_colors, width=3.5))

    plot.get_figure().savefig(out_file_name)


if __name__ == '__main__':
    catalog = "../data_processing/results/best-time/"

    generate_plot(catalog + "jsonAverage.json",
                  catalog + "Average.png")
    generate_plot(catalog + "jsonTopStoriesAverage.json",
                  catalog + "TopStoriesAverage.png", ylim=(500, 1500))
