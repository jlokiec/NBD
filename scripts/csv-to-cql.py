import csv
import sys
import uuid


def process_team_name(raw_name):
    if "'" in raw_name:
        raw_name = raw_name.replace("'", "")

    return raw_name


if __name__ == '__main__':
    if len(sys.argv) == 5:
        input_filename = sys.argv[1]
        output_filename = sys.argv[2]
        season = sys.argv[3]
        league = sys.argv[4]
        if input_filename.endswith('.csv'):
            with open(input_filename, 'r') as csvfile:
                reader = csv.reader(csvfile, delimiter=',')
                firstline = True
                queries = []
                for row in reader:
                    if firstline == False:
                        uid = uuid.uuid4()
                        date = row[0]
                        home_team = process_team_name(row[1])
                        away_team = process_team_name(row[2])
                        ft_home_goals = row[3]
                        ft_away_goals = row[4]
                        ft_sum_goals = int(ft_home_goals)+int(ft_away_goals)
                        ft_result = row[5]
                        ht_home_goals = row[6]
                        ht_away_goals = row[7]
                        ht_sum_goals = int(ht_home_goals)+int(ht_away_goals)
                        ht_result = row[8]
                        home_shots = row[9]
                        away_shots = row[10]
                        sum_shots = int(home_shots)+int(away_shots)
                        home_shots_target = row[11]
                        away_shots_target = row[12]
                        sum_shots_target = int(
                            home_shots_target)+int(away_shots_target)
                        home_fouls = row[13]
                        away_fouls = row[14]
                        sum_fouls = int(home_fouls)+int(away_fouls)
                        home_corners = row[15]
                        away_corners = row[16]
                        sum_corners = int(home_corners)+int(away_corners)
                        home_yellow = row[17]
                        away_yellow = row[18]
                        sum_yellow = int(home_yellow)+int(away_yellow)
                        home_red = row[19]
                        away_red = row[20]
                        sum_red = int(home_red)+int(away_red)

                        query = 'insert into european_league_results.game_results(uid, date, season, league, home_team, away_team, '\
                            'ft_home_goals, ft_away_goals, ft_sum_goals, ft_result, ht_home_goals, ht_away_goals, ht_sum_goals, '\
                            'ht_result, home_shots, away_shots, sum_shots, home_shots_target, away_shots_target, sum_shots_target, '\
                            'home_fouls, away_fouls, sum_fouls, home_corners, away_corners, sum_corners, home_yellow, away_yellow, '\
                            'sum_yellow, home_red, away_red, sum_red) values ({0}, \'{1}\', \'{2}\', \'{3}\', \'{4}\', \'{5}\', {6}, '\
                            '{7}, {8}, \'{9}\', {10}, {11}, {12}, \'{13}\', {14}, {15}, {16}, {17}, {18}, {19}, {20}, {21}, {22}, '\
                            '{23}, {24}, {25}, {26}, {27}, {28}, {29}, {30}, {31});\n'.format(uid, date, season, league, home_team,
                                                                                              away_team, ft_home_goals, ft_away_goals,
                                                                                              ft_sum_goals, ft_result, ht_home_goals,
                                                                                              ht_away_goals, ht_sum_goals, ht_result,
                                                                                              home_shots, away_shots, sum_shots,
                                                                                              home_shots_target, away_shots_target,
                                                                                              sum_shots_target, home_fouls, away_fouls,
                                                                                              sum_fouls, home_corners, away_corners,
                                                                                              sum_corners, home_yellow, away_yellow,
                                                                                              sum_yellow, home_red, away_red, sum_red)

                        queries.append(query)
                    else:
                        firstline = False

            with open(output_filename, 'a') as cqlfile:
                cqlfile.writelines(queries)

            print(
                f'Appended {len(queries)} insert statements to {output_filename}.')
        else:
            print('Given file is not a CSV file. Exiting.')
    else:
        print('Specify CSV file to process, season and league. Exiting.')
