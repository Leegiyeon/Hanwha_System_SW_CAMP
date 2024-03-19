
let theater = { 
    store: "강남점",
    title: ["파묘", "듄2", "웡카", "가여운 것들"],

    showMovieList(theater) {
        console.log(this.store);

        this.title.forEach(
            element => console.log(this.store + element)
        );
    }
    
}
console.log(theater.store);

theater.showMovieList();