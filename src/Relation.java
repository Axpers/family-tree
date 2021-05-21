public class Relation {

  public Relation(TypeRelation Type, Personne Personne1, Personne Personne2) {
    this.type = Type;
    this.personne1 = Personne1;
    this.personne2 = Personne2;

    personne1.liste_relations.add(this);
    personne2.liste_relations.add(this);
  }

  public TypeRelation type;

  public Personne personne1;

  public Personne personne2;

  enum TypeRelation {
    Mariage, Parent, Enfant;
  }
}
