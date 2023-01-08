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

    int imgID[] = {R.drawable.avatar, R.drawable.ripd2, R.drawable.blackpanther,R.drawable.blackadam,
            R.drawable.thor, R.drawable.minion,R.drawable.themanfromtoronto,R.drawable.jurassicworlddominion,
            R.drawable.topgun, R.drawable.doctorstrange, R.drawable.fatherstu, R.drawable.morbius,
            R.drawable.thebatman,R.drawable.blacklight,R.drawable.moonfall};

    String Name[] = {"Bullshit: The Way of Water", "R.I.P.D. 2: Rise of the Damned", "Black Panther: Wakanda Forever",
            "Black Adam", "THOR: LOVE AND THUNDER", "Minions: The Rise of Gru", "The Man from Toronto",
            "Jurassic World: Dominion", "Top Gun: Maverick", "Doctor Strange in the Multiverse of Madness",
            "Father Stu", "Morbius", "The Batman", "Blacklight", "Moonfall"};

    String releaseDate[] = {"16/12/2022", "15/11/2022", "11/11/2022", " 21/10/2022", "08/07/2022", "01/07/2022",
            "24/06/2022", "10/06/2022", "27/05/2022", "06/05/2022", "15/04/2022", "01/04/2022", "04/03/2022",
            "11/02/2022", "04/02/2022"};

    String ratePG[] = {"PG-13", "PG-13", "PG-13", "PG-13", "PG-13", "PG", "PG-13", "PG-13", "PG-13", "PG-13", "R",
            "PG-13", "PG-13", "PG-13", "PG-13"};

    String durationTime[] = {"3h10m", "1h42m", "2h41m", "2h05m", "2h13m", "1h30m", "1h50m", "2h08m", "2h26m",
            "2h10m", "2h04m", "1h48m", "2h55m", "1h44m", "2h10m"};

    String storyLine[] = {"Jake Sully lives with his newfound family formed on the extrasolar moon Pandora. " +
            "Once a familiar threat returns to finish what was previously started, Jake must work with Neytiri " +
            "and the army of the Na'vi race to protect their home.",

            "Set in the American West of 1876, 'R.I.P.D.2: Rise of the Damed' is a spiritual (pardon " +
                    "the pun) sequel to 2013's 'R.I.P.D.' Sheriff Roy Pulsipher isn't too thrilled " +
                    "about finding himself dead after a shoot out with a notorious outlaw gang, but he does " +
                    "get a second chance to return to earth after being recruited by the R.I.P.D. " +
                    "(Rest In Peace Department.). But avenging his own murder may have to take a back seat to " +
                    "saving the world when a gateway to hell is opened in the old mining town of Red Creek " +
                    "threatening not only the locals... but all of humanity itself.",

            "Queen Ramonda, Shuri, M'Baku, Okoye and the Dora Milaje fight to protect the kingdom " +
                    "of Wakanda from intervening world powers in the wake of King T'Challa's death. " +
                    "As the Wakandans strive to embrace their next chapter, the heroes must band together " +
                    "with the help of War Dog Nakia and Everett Ross and forge a new path for their nation.",

            "Reawakening after 5000 years, Black Adam becomes the world's ruthless protector: " +
                    "an anti-villain to take on the likes of Superman and Wonder Woman. Now in the 21st-Century, " +
                    "Black Adam must face off against the Justice Society of America and its heroes: Doctor Fate, " +
                    "Hawkman, Atom Smasher and Cyclone. The fate of the world hangs in the balance.",

            "Thor's retirement is interrupted by a galactic killer known as Gorr the God Butcher, " +
                    "who seeks the extinction of the gods. To combat the threat, Thor enlists the help of King Valkyrie, " +
                    "Korg and ex-girlfriend Jane Foster, who - to Thor's surprise - inexplicably wields his magical " +
                    "hammer, Mjolnir, as the Mighty Thor. Together, they embark upon a harrowing cosmic adventure to " +
                    "uncover the mystery of the God Butcher's vengeance and stop him before it's too late.",

            "In the heart of the 1970s, amidst a flurry of feathered hair and flared jeans, Gru (Steve Carell) " +
                    "is growing up in the suburbs. A fanboy of a supervillain supergroup known as the Vicious 6, Gru " +
                    "hatches a plan to become evil enough to join them. Luckily, he gets some mayhem-making back-up from " +
                    "his loyal followers, the Minions. Together, Kevin, Stuart, Bob, and Otto - a new Minion sporting " +
                    "braces and a desperate need to please - deploy their skills as they and Gru build their first lair, " +
                    "experiment with their first weapons, and pull off their first missions. When the Vicious 6 oust their " +
                    "leader, legendary fighter Wild Knuckles (Alan Arkin), Gru interviews to become their newest member. " +
                    "It doesn't go well (to say the least), and only gets worse after Gru outsmarts them and suddenly " +
                    "finds himself the mortal enemy of the apex of evil. On the run, Gru will turn to an unlikely source " +
                    "for guidance, Wild Knuckles, and discover that even bad guys need a little help from their friends.",

            "The world's deadliest assassin and New York's biggest screw-up are mistaken for " +
                    "each other at an Airbnb rental.",

            "After surviving the destruction of Isla Nubla, Owen Grady and Claire Dearing took in young Maisie Lockwood. " +
                    "They've been living under the radar to protect Maisie, but she feels like a prisoner. When Maisie " +
                    "goes missing, Owen and Claire set out to find her, and eventually confront Lewis Dodgson, owner of " +
                    "Biosyn. Paleobotanist Ellie Sattler, Paleontologist Alan Grant, and Chaotician Ian Malcolm set out to " +
                    "expose Dodgson's schemes.",

            "Set 30 years after its predecessor, it follows Maverick's return to the United States Navy Strike Fighter " +
                    "Tactics Instructor program (also known as U.S. Navy-Fighter Weapons School - \"TOPGUN\"), where " +
                    "he must confront his past as he trains a group of younger pilots, among them the son of Maverick's " +
                    "deceased best friend Lieutenant Nick \"Goose\" Bradshaw, USN.",

            "Following the events of Spider-Man No Way Home, Doctor Strange unwittingly casts a forbidden spell that " +
                    "accidentally opens up the multiverse. With help from Wong and Scarlet Witch, Strange confronts various " +
                    "versions of himself as well as teaming up with the young America Chavez while traveling through various " +
                    "realities and working to restore reality as he knows it. Along the way, Strange and his allies realize " +
                    "they must take on a powerful new adversary who seeks to take over the multiverse.",

            "Follows the life of Father Stuart Long, a boxer-turned-priest who inspired countless people during " +
                    "his journey from self-destruction to redemption.",
            "Dangerously ill with a rare blood disorder, and determined to save others suffering his same fate, " +
                    "Dr. Morbius attempts a desperate gamble. What at first appears to be a radical success soon reveals " +
                    "itself to be a remedy potentially worse than the disease.",
            "Batman ventures into Gotham City's underworld when a sadistic killer leaves behind a trail of cryptic " +
                    "clues. As the evidence begins to lead closer to home and the scale of the perpetrator's plans " +
                    "become clear, he must forge new relationships, unmask the culprit and bring justice to the abuse of " +
                    "power and corruption that has long plagued the metropolis.",

            "Political activist Sofia is killed in an apparent hit-and-run accident outside of her home. Vietnam War " +
                    "veteran Travis Block works as a fixer for the Director of the FBI, Gabriel Robinson.Travis wants to " +
                    "retire and spend more time with his daughter and granddaughter. Mira, a journalist, claims to have " +
                    "information about Sofia's death and proof that it was not an accident. She got the intel from Dusty. " +
                    "Dusty also claims to have information about a top secret FBI operation called Project Unity, which " +
                    "kills innocent civilians like Sofia. Gabriel tells Travis that his last assignment is to bring in " +
                    "Dusty Crane. Travis has no choice now but to confront his FBI boss Gabriel with this information. " +
                    "Who is speaking the truth?",

            "In Moonfall, a mysterious force knocks the Moon from its orbit around Earth and sends it hurtling on " +
                    "a collision course with life as we know it. With mere weeks before impact and the world on the brink " +
                    "of annihilation, NASA executive and former astronaut Jo Fowler is convinced she has the key to saving " +
                    "us all - but only one astronaut from her past, Brian Harper and a conspiracy theorist K.C. Houseman " +
                    "believe her. These unlikely heroes will mount an impossible last-ditch mission into space, leaving " +
                    "behind everyone they love, only to find that they just might have prepared for the wrong mission."};

    String director[] ={"James Cameron", "Paul Leyden", "Ryan Coogler", "Jaume Collet-Serra", "Taika Waititi",
            "Kyle Balda", "Patrick Hughes", "Colin Trevorrow", "Joseph Kosinski", "Sam Raimi", "Sam Raimi",
            "Daniel Espinosa", "Matt Reeves", "Mark Williams", "Roland Emmerich"};

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
