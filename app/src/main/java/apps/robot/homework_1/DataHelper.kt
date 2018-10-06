package apps.robot.homework_1

fun getData(): ArrayList<User> {
    val list = ArrayList<User>()
    list.add(User("Ayaz", R.drawable.ayaz, "Guitar,programming,eating"))
    list.add(User("Batman", R.drawable.batman, "Fighting criminals"))
    list.add(User("Venom", R.drawable.venom, "Eating people"))
    list.add(User("Vladimir Putin", R.drawable.putin, "Nologi"))
    return list
}