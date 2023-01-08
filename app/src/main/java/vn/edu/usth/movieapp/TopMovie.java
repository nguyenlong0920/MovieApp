package vn.edu.usth.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class TopMovie extends Fragment {

    int imgID[] = {R.drawable.godfather, R.drawable.schindlerlist, R.drawable.angrymen,R.drawable.lifeisbeautiful,
            R.drawable.thegood, R.drawable.theshawshank,R.drawable.thepursuit,R.drawable.sevensamurai,
            R.drawable.untouchable, R.drawable.centralstation, R.drawable.thedarknight, R.drawable.judgementday,
            R.drawable.savingprivateryan,R.drawable.gladiator,R.drawable.backtothefuture};

    String Name[] = {"The Godfather", "Schindler's List", "12 Angry Men",
            "Life Is Beautiful", "The Good, the Bad and the Ugly", "The Shawshank Redemption",
            "The Pursuit of Happyness", "Seven Samurai", "Untouchable", "Central Station",
            "The Dark Knight", "Terminator 2: Judgment Day", "Saving Private Ryan", "Gladiator", "Back to the Future"};

    String releaseDate[] = {"14/03/1972", "30/11/1993", "10/04/1957", "20/12/1997", "23/12/1966", "10/09/1994",
            "15/12/2006", "26/04/1954", "23/09/2011", "16/01/1998", "14/07/2008", "01/07/1991", "21/07/1998",
            "01/05/2000", "03/07/1985"};

    String ratePG[] = {"R", "R", "PG-13", "PG-13", "R", "R", "PG-13", "PG-13", "R", "PG-13", "PG-13",
            "R", "R", "R", "PG"};

    String durationTime[] = {"2h55m", "3h15m", "1h36m", "1h56m", "2h41m", "2h22m", "1h56m", "3h27m", "1h50m",
            "1h50m", "2h32m", "2h16m", "2h49m", "2h34m", "1h56m"};

    String storyLine[] = {"The Godfather \"Don\" Vito Corleone is the head of the Corleone mafia family in New York. " +
            "He is at the event of his daughter's wedding. Michael, Vito's youngest son and a decorated WW II Marine " +
            "is also present at the wedding. Michael seems to be uninterested in being a part of the family business. " +
            "Vito is a powerful man, and is kind to all those who give him respect but is ruthless against those who do not. " +
            "But when a powerful and treacherous rival wants to sell drugs and needs the Don's influence for the same, " +
            "Vito refuses to do it. What follows is a clash between Vito's fading old values and the new ways which " +
            "may cause Michael to do the thing he was most reluctant in doing and wage a mob war against all the other " +
            "mafia families which could tear the Corleone family apart.",

            "Oskar Schindler is a vain and greedy German businessman who becomes an unlikely humanitarian amid the " +
            "barbaric German Nazi reign when he feels compelled to turn his factory into a refuge for Jews. Based on " +
            "the true story of Oskar Schindler who managed to save about 1100 Jews from being gassed at the Auschwitz " +
            "concentration camp, it is a testament to the good in all of us.",

            "The defense and the prosecution have rested, and the jury is filing into the jury room to decide if a young " +
            "man is guilty or innocent of murdering his father. What begins as an open-and-shut case of murder soon becomes " +
            "a detective story that presents a succession of clues creating doubt, and a mini-drama of each of the " +
            "jurors'prejudices and preconceptions about the trial, the accused, AND each other. Based on the play, all of " +
            "the action takes place on the stage of the jury room.",

            "In 1930s Italy, a carefree Jewish waiter named Guido starts a fairy tale life by courting and marrying a lovely " +
            "woman from a nearby city. Guido and his wife have a son and live happily together until the occupation of " +
            "Italy by German forces. In an attempt to hold his family together and help his son survive the horrors of a Jewish " +
            "Concentration Camp, Guido imagines that the Holocaust is a game and that the grand prize for winning is a tank.",

            "Blondie, The Good (Clint Eastwood), is a professional gunslinger who is out trying to earn a few dollars. " +
            "Angel Eyes, The Bad (Lee Van Cleef), is a hitman who always commits to a task and sees it through - as long " +
            "as he's paid to do so. And Tuco, The Ugly (Eli Wallach), is a wanted outlaw trying to take care of his own hide. " +
            "Tuco and Blondie share a partnership making money off of Tuco's bounty, but when Blondie unties the partnership, " +
            "Tuco tries to hunt down Blondie. When Blondie and Tuco come across a horse carriage loaded with dead bodies, " +
            "they soon learn from the only survivor, Bill Carson (Antonio Casale), that he and a few other men have buried a stash " +
            "of gold in a cemetery. Unfortunately, Carson dies and Tuco only finds out the name of the cemetery, while Blondie finds out " +
            "the name on the grave. Now the two must keep each other alive in order to find the gold. Angel Eyes (who had been looking " +
            "for Bill Carson) discovers that Tuco and Blondie met with Carson and knows they know where the gold is; now he needs " +
            "them to lead him to it. Now The Good, the Bad, and the Ugly must all battle it out to get their hands on $200,000.00 worth of gold.",

            "Chronicles the experiences of a formerly successful banker as a prisoner in the gloomy jailhouse of " +
            "Shawshank after being found guilty of a crime he did not commit. The film portrays the man's unique " +
            "way of dealing with his new, torturous life; along the way he befriends a number of fellow prisoners, " +
            "most notably a wise long-term inmate named Red.",

            "Based on a true story about a man named Christopher Gardner. Gardner has invested heavily in a " +
            "device known as a \"bone density scanner\". He feels like he has it made selling these devices. " +
            "However, they do not sell well as they are marginally better than x-ray at a much higher price. " +
            "As Gardner works to make ends meet, his wife leaves him and he loses his apartment. Forced to " +
            "live out in the streets with his son, Gardner continues to sell bone density scanners while " +
            "concurrently taking on an unpaid internship as a stockbroker, with slim chances for advancement " +
            "to a paid position. Before he can receive pay, he needs to outshine the competition through " +
            "6 months of training, and to sell his devices to stay afloat.",

            "A veteran samurai, who has fallen on hard times, answers a village's request for protection " +
            "from bandits. He gathers 6 other samurai to help him, and they teach the townspeople how to " +
            "defend themselves, and they supply the samurai with three small meals a day. The film culminates " +
            "in a giant battle when 40 bandits attack the village.",

            "In Paris, the aristocratic and intellectual Philippe is a quadriplegic millionaire who is " +
            "interviewing candidates for the position of his carer, with his red-haired secretary Magalie. " +
            "Out of the blue, Driss cuts the line of candidates and brings a document from the Social " +
            "Security and asks Phillipe to sign it to prove that he is seeking a job position so he can " +
            "receive his unemployment benefit. Philippe challenges Driss, offering him a trial period of " +
            "one month to gain experience helping him. Then Driss can decide whether he would like to " +
            "stay with him or not. Driss accepts the challenge and moves to the mansion, changing the " +
            "boring life of Phillipe and his employees.",

            "Dora, a dour old woman who hates customers and calls them 'trash', works at a Rio de " +
            "Janeiro central station writing and mailing letters for customers. Josue is a 9-year-old " +
            "boy who never met his father. His mother is sending letters to his father through Dora. " +
            "When she dies in a car accident, Dora takes Josue on a trip to find his father.",

            "Set within a year after the events of Batman Begins (2005), Batman, Lieutenant James Gordon, " +
            "and new District Attorney Harvey Dent successfully begin to round up the criminals that plague " +
            "Gotham City, until a mysterious and sadistic criminal mastermind known only as \"The Joker\" " +
            "appears in Gotham, creating a new wave of chaos. Batman's struggle against The Joker becomes " +
            "deeply personal, forcing him to \"confront everything he believes\" and improve his technology " +
            "to stop him. A love triangle develops between Bruce Wayne, Dent, and Rachel Dawes.",

            "Over 10 years have passed since the first machine called The Terminator tried to kill Sarah " +
            "Connor and her unborn son, John. The man who will become the future leader of the human " +
            "resistance against the Machines is now a healthy young boy. However, another Terminator, " +
            "called the T-1000, is sent back through time by the supercomputer Skynet. This new Terminator " +
            "is more advanced and more powerful than its predecessor and its mission is to kill John Connor " +
            "when he's still a child. However, Sarah and John do not have to face the threat of the " +
            "T-1000 alone. Another Terminator (identical to the same model that tried and failed to kill " +
            "Sarah Connor in 1984) is also sent back through time to protect them. Now, the battle for tomorrow has begun.",

            "Opening with the Allied invasion of Normandy on 6 June 1944, members of the 2nd Ranger " +
            "Battalion under Cpt. Miller fight ashore to secure a beachhead. Amidst the fighting, " +
            "two brothers are killed in action. Earlier in New Guinea, a third brother is KIA. " +
            "Their mother, Mrs. Ryan, is to receive all three of the grave telegrams on the same day. " +
            "The United States Army Chief of Staff, George C. Marshall, is given an opportunity to " +
            "alleviate some of her grief when he learns of a fourth brother, Private James Ryan, and " +
            "decides to send out 8 men (Cpt. Miller and select members from 2nd Rangers) to find him " +
            "and bring him back home to his mother...",

            "Maximus is a powerful Roman general, loved by the people and the aging Emperor, " +
            "Marcus Aurelius. Before his death, the Emperor chooses Maximus to be his heir over his own son, " +
            "Commodus, and a power struggle leaves Maximus and his family condemned to death. The powerful " +
            "general is unable to save his family, and his loss of will allows him to get captured and put " +
            "into the Gladiator games until he dies. The only desire that fuels him now is the chance to rise " +
            "to the top so that he will be able to look into the eyes of the man who will feel his revenge.",

            "Marty McFly, a typical American teenager of the Eighties, is accidentally sent back to " +
            "1955 in a plutonium-powered DeLorean \"time machine\" invented by a slightly mad scientist. " +
            "During his often hysterical, always amazing trip back in time, Marty must make certain " +
            "his teenage parents-to-be meet and fall in love - so he can get back to the future."};

    String director[] ={"Francis Ford Coppola", "Steven Spielberg", "Sidney Lumet", "Roberto Benigni", "Sergio Leone",
            "Frank Darabont", "Gabriele Muccino", "Akira Kurosawa", "Olivier Nakache", "Walter Salles", "Christopher Nolan",
            "James Cameron", "Steven Spielberg", "Ridley Scott", "Robert Zemeckis"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_top_movie, container, false);
        ListView listView = view.findViewById(R.id.listTopMovie);

        List<Movie> listItems = new ArrayList<>();

        CustomAdapter customAdapter;

        for(int i = 0;i < imgID.length;i++){

            Movie movie = new Movie(Name[i],releaseDate[i],ratePG[i],
                    durationTime[i],storyLine[i],director[i],imgID[i]);
            listItems.add(movie);

        }

        customAdapter = new CustomAdapter(listItems, TopMovieActivity.class);

        listView.setAdapter(customAdapter);

        return view;
    }

    public class CustomAdapter extends BaseAdapter implements Filterable {

        private List<Movie> movieList;
        private List<Movie> movieListFiltered;

        private Class<TopMovieActivity> context;

        public CustomAdapter(List<Movie> movieList, Class<TopMovieActivity> context) {
            this.movieList = movieList;
            this.movieListFiltered = movieList;
            this.context = context;
        }

        @Override
        public int getCount() {

            return movieListFiltered.size();
        }

        @Override
        public Object getItem(int position) {

            return null;
        }

        @Override
        public long getItemId(int position) {

            return position;
        }

        @Override
        public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.list_nowshowing,null);

            ImageView movieImage = view.findViewById(R.id.movieImage);
            TextView movieName = view.findViewById(R.id.movieName);
            TextView release = view.findViewById(R.id.release);
            TextView rate = view.findViewById(R.id.rate);
            TextView duration = view.findViewById(R.id.duration);

            movieImage.setImageResource(movieListFiltered.get(position).getImgID());
            movieName.setText(movieListFiltered.get(position).getName());
            release.setText(movieListFiltered.get(position).getReleaseDate());
            rate.setText(movieListFiltered.get(position).getRatePG());
            duration.setText(movieListFiltered.get(position).getDurationTime());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), TopMovieActivity.class);
                    intent.putExtra("item", movieListFiltered.get(position));
                    startActivity(intent);
                }
            });

            return view;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {

                    FilterResults filterResults = new FilterResults();

                    if (constraint == null || constraint.length() == 0) {

                        filterResults.count = movieList.size();
                        filterResults.values = movieList;

                    } else {
                        String searchStr = constraint.toString().toLowerCase();

                        List<Movie> resultData = new ArrayList<>();

                        for (Movie itemsModel: movieList) {

                            if (itemsModel.getName().toLowerCase().contains(searchStr)) {
                                resultData.add(itemsModel);
                            }

                            filterResults.count = resultData.size();
                            filterResults.values = resultData;

                        }

                    }

                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {

                    movieListFiltered = (List<Movie>) results.values;

                    notifyDataSetChanged();

                }
            };

            return filter;
        }
    }

}
