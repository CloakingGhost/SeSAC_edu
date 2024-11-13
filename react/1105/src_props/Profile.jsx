function Avatar({ person, size }) {
  size = 200
  return (
    <img
      className="avatar"
      src={person.imgUrl}
      alt={person.name}
      width={size}
      height={size}
    />
  );
}

export default function Profile(props) {
  const { person, size } = props;
  return (
    <>
      <Avatar 
      {...props}
      />
    </>
  );
}
