package com.movieshop.movieservice.config;

import com.movieshop.movieservice.models.Movie;
import com.movieshop.movieservice.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MovieConfig {
    @Bean
    public CommandLineRunner seedingMovieData(MovieRepository repo){
        return args -> {
            if(repo.findAll().isEmpty()){

                Movie m1 = new Movie("Animal","Animal is a 2023 Indian Hindi-language action drama film[1][5] co-written, directed and edited by Sandeep Reddy Vanga and produced by T-Series Films, Bhadrakali Pictures and Cine1 Studios. The film stars Ranbir Kapoor, Anil Kapoor, Bobby Deol, Rashmika Mandanna and Triptii Dimri. The film follows Ranvijay, the ruthless son of a powerful industrialist, and his troubled relationship with his father, which gets further jeopardized as he sets out on a path of vengeance and destruction after an assassination attempt on his father.","https://upload.wikimedia.org/wikipedia/en/thumb/9/90/Animal_%282023_film%29_poster.jpg/220px-Animal_%282023_film%29_poster.jpg",2023);
                Movie m2= new Movie("Kabir Singh","Kabir Singh is a 2019 Indian Hindi-language romantic drama film co-written, co-edited and directed by Sandeep Reddy Vanga and jointly produced by Bhushan Kumar and Krishan Kumar under T-Series Films and Murad Khetani and Ashwin Varde under Cine1 Studios. A remake of Vanga's own Telugu film Arjun Reddy (2017), it stars Shahid Kapoor in the title role as a doctor who spirals into self-destruction when his girlfriend, played by Kiara Advani, marries someone else. Adil Hussain, Nikita Dutta, Arjan Bajwa, Suresh Oberoi, Dolly Minhas, Suparna Marwah, Anurag Arora, Soham Majumdar, Kunal Thakur, Anusha Sampath, Amit Sharma and Kamini Kaushal feature in supporting roles.","https://upload.wikimedia.org/wikipedia/en/thumb/d/dc/Kabir_Singh.jpg/220px-Kabir_Singh.jpg",2019);
                Movie m4 = new Movie("War","War is a 2019 Indian Hindi-language action thriller film directed by Siddharth Anand, who co-wrote the script with Shridhar Raghavan, Abbas Tyrewala and Aditya Chopra, and produced by Chopra's Yash Raj Films. The film stars Hrithik Roshan and Tiger Shroff in the lead roles, alongside Vaani Kapoor, Ashutosh Rana, Anupriya Goenka, Dipannita Sharma, Sanjeev Vatsa, Mashhoor Amrohi, Yash Raaj Singh, Arif Zakaria and Mohit Chauhan. It is the third installment in the YRF Spy Universe. In the film, an Indian RAW agent, is assigned to eliminate his former mentor who has gone rogue.","https://upload.wikimedia.org/wikipedia/en/thumb/6/6f/War_official_poster.jpg/220px-War_official_poster.jpg",2019);
                Movie m3 = new Movie("An Action Hero","An Action Hero is a 2022 Indian Hindi-language action film[2] directed by newcomer Anirudh Iyer and produced by T-Series and Colour Yellow Productions. It stars Ayushmann Khurrana and Jaideep Ahlawat. In the film, an action star (Khurrana) goes on the run after accidentally killing the brother of a ruthless politician (Ahlawat).","https://upload.wikimedia.org/wikipedia/en/thumb/4/47/An_Action_Hero_film_poster.jpg/220px-An_Action_Hero_film_poster.jpg",2022);

                System.out.println("DB is seeding..........");
                repo.saveAll(Arrays.asList(m1,m2,m3,m4));
                System.out.println("DB seeding done ..........");
            }
        };
    }
}
