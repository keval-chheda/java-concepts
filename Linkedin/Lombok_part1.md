Nowadays, writing code isn’t enough. It has to be clean, readable, and optimized. One thing that helped me cut down legacy practices was reducing all the boilerplate we’ve been writing for years.

🚀 My Lombok Moment
Like many Java developers, I started by writing endless getters, setters, and constructors.
The day I added @Data to a POJO and watched 30 lines disappear… magical.
But the more I used Lombok, the more I realized:
the real skill isn’t using Lombok — it’s knowing when not to.

✅ Where Lombok genuinely helps
@Data → simple, mutable DTOs
@Value → objects that should never change
@RequiredArgsConstructor → enforce required fields without exposing everything

⚠️ Where Lombok can make things worse
@NoArgsConstructor → lets you create objects in an invalid state
@AllArgsConstructor → bypasses validation by exposing every field

❌ And the biggest trap: Bidirectional JPA Relationships
If you have entities referencing each other (User ↔ Orders), using @Data or default @EqualsAndHashCode / @ToString is a recipe for:
infinite recursion
stack overflow
unexpected lazy loading
unstable equality checks

Because:
User.toString() calls orders → each Order.toString() calls user → which calls orders again… forever.

Better: Use selective annotations:
@Getter
@Setter
@ToString(exclude = "orders")
@EqualsAndHashCode(exclude = "orders")
Or write them manually if the relationship is complex.

Lombok is a great tool but clean design still comes from intention, not shortcuts. Whats your learnings and experience from lombok ?

hashtag#Java hashtag#Lombok hashtag#CleanCode hashtag#CleanCodeAdvocate hashtag#SoftwareDesign hashtag#JPA
hashtag#SystemDesign hashtag#SRP