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

public class TopTvSeries extends Fragment {

    int imgID[] = {R.drawable.breakingbad, R.drawable.gameofthrones, R.drawable.rickandmorty,R.drawable.sherlock,
            R.drawable.batman, R.drawable.attackontitan,R.drawable.theoffice,R.drawable.deathnote,
            R.drawable.bettercallsaul, R.drawable.friends, R.drawable.theboys, R.drawable.thesimpsons,
            R.drawable.strangerthings,R.drawable.invincible,R.drawable.startrek};

    String Name[] = {"Breaking Bad", "Game of Thrones", "Rick and Morty", "Sherlock",
            "Batman: The Animated Series", "Attack on Titan", "The Office",
            "Death Note", "Better Call Saul", "Friends", "The Boys", "The Simpsons",
            "Stranger Things", "Invincible", "Star Trek: The Next Generation"};

    String releaseDate[] = {"2008–2013", "2011–2019", "2013-Now", "2010-2017", "1992-1995", "2013-Now",
            "2005-2013", "2006-2007", "2015-2022", "1994-2004", "2019-Now", "1989-Now", "2016-Now",
            "2021-Now", "1987-1994"};

    String ratePG[] = {"R", "R", "R", "R", "PG", "R", "PG-13", "R", "R", "PG", "R",
            "PG", "PG-13", "R", "PG"};

    String durationTime[] = {"49m", "57m", "23m", "1h28m", "23m", "24m", "22m", "23m", "46m",
            "22m", "1h", "22m", "51m", "50m", "44m"};

    String storyLine[] = {"Walter H. White is a chemistry genius, but works as a chemistry teacher " +
            "in an Albequerque, New Mexico high school. His life drastically changes when he's " +
            "diagnosed with stage III terminal lung cancer, and given a short amount of time left " +
            "to live: a mere matter of months. To ensure his handicapped son and his pregnant wife " +
            "have a financial future, Walt uses his chemistry background to create and sell the " +
            "world's finest crystal methamphetamine. To sell his signature \"blue meth,\" he " +
            "teams up with Jesse Pinkman, a former student of his. The meth makes them very rich " +
            "very quickly, but it attracts the attention of his DEA brother in law Hank. As Walt " +
            "and Jesse's status in the drug world escalates, Walt becomes a dangerous criminal and " +
            "Jesse becomes a hot-headed salesman. Hank is always hot on his tail, and it forces Walt " +
            "to come up with new ways to cover his tracks.",

            "In the mythical continent of Westeros, several powerful families fight for control of " +
            "the Seven Kingdoms. As conflict erupts in the kingdoms of men, an ancient enemy rises " +
            "once again to threaten them all. Meanwhile, the last heirs of a recently usurped dynasty " +
            "plot to take back their homeland from across the Narrow Sea.",

            "An animated series on adult-swim about the infinite adventures of Rick, a genius " +
            "alcoholic and careless scientist, with his grandson Morty, a 14 year-old anxious boy " +
            "who is not so smart. Together, they explore the infinite universes; causing mayhem and running into trouble.",

            "In this modernized version of the Conan Doyle characters, using his detective plots, " +
            "Sherlock Holmes lives in early-21st-century London and acts more cocky towards " +
            "Scotland Yard's detective inspector Lestrade because he's actually less confident. " +
            "Doctor Watson is now a fairly young veteran of the Afghan war, less adoring and more active.",

            "Heir to the Wayne family fortune, Bruce Wayne (Kevin Conroy) lives by day as a seemingly " +
            "lavish playboy millionaire socialite, but by night assumes the role of his crime-fighting " +
            "alter-ego: the caped crusader known as The Batman. Throughout the show, Batman receives " +
            "help from sidekicks Dick Grayson/Robin (Loren Lester) and Barbara Gordon/Batgirl (Melissa " +
            "Gilbert), as well as Police Commissioner James Gordon (Bob Hastings), in protecting the " +
            "streets of Gotham City from a large rogue's gallery of criminals, lunatics, and nemeses.",

            "Humans are nearly exterminated by giant creatures called Titans. Titans are typically " +
            "several stories tall, seem to have no intelligence, devour human beings and, worst of all, " +
            "seem to do it for the pleasure rather than as a food source. A small percentage of humanity " +
            "survived by walling themselves in a land protected by extremely high walls, even taller " +
            "than the biggest of titans. Flash forward to the present, and mankind has not seen a titan " +
            "in over 100 years. One day, 10 year old Eren and his foster sister Mikasa witness something " +
            "horrific as the city walls are destroyed by a colossal titan that appears out of thin air. " +
            "As the smaller titans flood the city, the two kids watch in horror as their mother is " +
            "eaten alive. Eren vows that he will murder every single titan and take revenge for all of mankind.",

            "A mediocre paper company in the hands of Scranton, PA branch manager Michael Scott. This " +
            "mockumentary follows the everyday lives of the manager and the employees he \"manages.\" " +
            "The crew follows the employees around 24/7 and captures their quite humorous and bizarre " +
            "encounters as they will do what it takes to keep the company thriving.",

            "After an intelligent yet cynical high school student begins to cleanse the world from evil " +
            "with the help of a magical notebook that can kill anyone whose name is written on it, " +
            "international authorities call upon a mysterious detective known as \"L\" to thwart his efforts.",

            "Before Saul Goodman, he was Jimmy McGill. And if you're calling Jimmy, you're in real trouble. " +
            "The prequel to \"Breaking Bad\" follows small-time attorney, Jimmy McGill, as he transforms " +
            "into Walter White's morally challenged lawyer, Saul Goodman.",

            "Ross Geller, Rachel Green, Monica Geller, Joey Tribbiani, Chandler Bing, and Phoebe Buffay " +
            "are six twenty-somethings living in New York City. Over the course of 10 years and seasons, " +
            "these friends go through life lessons, family, love, drama, friendship, and comedy.",

            "\"The Boys\" is set in a universe in which superpowered people are recognized as heroes by " +
            "the general public and owned by a powerful corporation, Vought International, which " +
            "ensures that they are aggressively marketed and monetized. Outside of their heroic personas, " +
            "most are arrogant and corrupt. The series primarily focuses on two groups: the titular Boys, " +
            "vigilantes looking to keep the corrupted heroes under control, and the Seven, Vought " +
            "International's premier superhero team. The Boys are led by Billy Butcher, who despises " +
            "all superpowered people, and the Seven are led by the egotistical and unstable Homelander. " +
            "As a conflict ensues between the two groups, the series also follows the new members of each " +
            "team: Hugh \"Hughie\" Campbell of the Boys, who joins the vigilantes after his girlfriend " +
            "is killed in a high-speed collision by the Seven's A-Train, and Annie January/Starlight of " +
            "the Seven, a hopeful young heroine forced to face the truth about the heroes she admires.",

            "This is an animated sitcom about the antics of a dysfunctional family. Homer is the oafish " +
            "unhealthy beer loving father, Marge is the hardworking homemaker wife, Bart is the perpetual " +
            "ten-year-old underachiever (and proud of it), Lisa is the unappreciated eight-year-old genius, " +
            "and Maggie is the cute, pacifier loving silent infant.",

            "In a small town where everyone knows everyone, a peculiar incident starts a chain of events " +
            "that leads to a child's disappearance, which begins to tear at the fabric of an otherwise-peaceful " +
            "community. Dark government agencies and seemingly malevolent supernatural forces converge on " +
            "the town, while a few of the locals begin to understand that more is going on than meets the eye.",

            "The son of Earth's most powerful superhero is about to become something greater than " +
            "himself: something bold, something universal, something - Invincible. From the comics to " +
            "the screen, Invincible follows Mark Grayson's journey of becoming Earth's next great " +
            "defender after his father, Nolan Grayson: also known as Omni-Man.",

            "Set in the 24th century and seven to eight decades after the adventures of the original " +
            "crew of the starship Enterprise, this series is the long-awaited successor to Star Trek (1966). " +
            "Under the command of Captain Jean-Luc Picard, the all new Enterprise NCC 1701-D travels out to " +
            "distant planets to seek out new life and to boldly go where no one has gone before."};

    String director[] ={"Vince Gilligan", "David Benioff", "Dan Harmon", "Mark Gatiss", "Bob Kane",
            "Marina Inoue", "Greg Daniels", "Shûsuke Kaneko", "Vince Gilligan", "David Crane", "Eric Kripke",
            "James L. Brooks", "Millie Bobby Brown", "Robert Kirkman", "Gene Roddenberry"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_top_tv_series, container, false);
        ListView listView = view.findViewById(R.id.listTopTvSeries);

        List<Movie> listItems = new ArrayList<>();

        CustomAdapter customAdapter;

        for(int i = 0;i < imgID.length;i++){

            Movie movie = new Movie(Name[i],releaseDate[i],ratePG[i],
                    durationTime[i],storyLine[i],director[i],imgID[i]);
            listItems.add(movie);

        }

        customAdapter = new CustomAdapter(listItems, TopTvSeriesActivity.class);

        listView.setAdapter(customAdapter);

        return view;
    }

    public class CustomAdapter extends BaseAdapter implements Filterable {

        private List<Movie> movieList;
        private List<Movie> movieListFiltered;

        private Class<TopTvSeriesActivity> context;

        public CustomAdapter(List<Movie> movieList, Class<TopTvSeriesActivity> context) {
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
                    Intent intent = new Intent(getActivity(), TopTvSeriesActivity.class);
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
